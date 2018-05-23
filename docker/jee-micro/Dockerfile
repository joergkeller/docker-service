FROM payara/micro

COPY *.war /opt/payara/deployments

CMD ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploymentDir", "/opt/payara/deployments/"]