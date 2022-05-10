#!/usr/bin/groovy
def VERSION
def TAGGED

node {
    stage("Checkout Source Code"){
        echo "Checkout Source Code"
        checkout scm

        if (env.TAG_NAME){
            VERSION = env.TAG_NAME.substring(1)
            echo "${VERSION}"
            TAGGED = true
        }else{
            TAGGED = false
        }
    }

    stage ("Run init tests") {
        echo "Running unit tests"
        sh "mvn test"
    }

    stage("Prepare release"){
        if (TAGGED){
            sh "mvn versions:set -DnewVersion=${VERSION}"
            sh "mvn versions:commit"
        }
    }

    stage ("Build project") {
        echo "Build project"
        sh "mvn package -DskipTests"
    }

    stage("Deploy") {
        echo "Deploying project"
        configFileProvider([configFile(fileId: '9c9b5492-c9ce-4f6b-86e7-825a3372f026', variable: 'MAVEN_SETTINGS')]) {
        // Exécuter la commande mvn avec le settings
        sh "mvn deploy -s $MAVEN_SETTINGS -Preposilite"
    }

}
}

