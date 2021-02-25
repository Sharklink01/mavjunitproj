node ('slave1') {
    def mvnHome = tool 'localMaven'
	stage ('checkout code'){
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ce186163-be7f-4c44-81b9-2c6334ad6f96', url: 'https://github.com/Sharklink01/mavjunitproj.git']]])
	}
	stage ('Build'){
		sh "${mvnHome}/bin/mvn clean install"
	}
	stage ('Code Quality scan')  {
        withSonarQubeEnv(credentialsId: '19f585d4-3420-4b09-869d-79a3ab651f9f') {
        sh "${mvnHome}/bin/mvn sonar:sonar"
        }
    stage ('Slack notification')  {
        slackSend(color: 'good', channel: '#jenkins-build-channel', message: "Job is successful, here is the info -  Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }
    }
}
