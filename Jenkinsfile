node {
    stage('Fetch repository'){
        checkout scm
    }
    stage('Build'){
        sh "mvn package -D skipTests"
    }
    stage('Tests'){
        sh "mvn test"
    }
    stage("Deploy"){
        configFileProvider([configFile(fileId:"9c9b5492-c9ce-4f6b-86e7-825a3372f026", variable: 'MAVEN_SETTINGS')]){
            sh "mvn deploy -s $MAVEN_SETTINGS -P reposilite"
        }
    }
}
