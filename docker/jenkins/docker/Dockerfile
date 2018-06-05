#
# See also:
# https://github.com/jenkinsci/docker#preinstalling-plugins
# https://technologyconversations.com/2017/06/16/automating-jenkins-docker-setup/
# https://github.com/galexandre/docker-jenkins-sonarqube
# https://github.com/peterjenkins1/jenkins-scripts
#

FROM jenkins/jenkins:lts-alpine

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY --chown=jenkins:jenkins jobs /var/jenkins_home/jobs

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt