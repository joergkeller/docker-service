#!groovy

import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule
import hudson.security.csrf.DefaultCrumbIssuer

def instance = Jenkins.getInstance()

instance.setCrumbIssuer(new DefaultCrumbIssuer(true))

// create admin
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin")
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

// no jnlp
instance.setSlaveAgentPort(-1)

// remove deprecated protocols
HashSet<String> protocols = new HashSet<>(instance.getAgentProtocols())
protocols.removeAll(Arrays.asList("CLI-connect", "JNLP-connect", "JNLP2-connect", "JNLP3-connect"))
instance.setAgentProtocols(protocols)

// no remoting
instance.getDescriptor("jenkins.CLI").get().setEnabled(false)

instance.save()
