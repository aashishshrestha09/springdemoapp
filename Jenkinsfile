// CODE_CHANGES = getGitChanges()
def gv 

pipeline {
  agent any
  parameters {
    // string(name: 'VERSION', defaultValue: '', descrption: 'version to deploy on prod')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0'], descrption: '')
    booleanParam(name: 'executeTests', defaultValue: true, descrption: '')
  }

  environment {
    NEW_VERSION = '1.3.0'
    // SERVER_CREDENTIALS = credentials('my-demo-project')
  }
  tools {
    maven 'Maven-3.8.4'
  }
  stages {
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage("build") {
      // when {
      //   expression {
      //     BRANCH_NAME == 'dev' && CODE_CHANGES == true
      //   }
      // }
      steps {
        script {
          gv.buildApp()
        }
      }
    }
    stage("test") {
      // when {
      //   expression {
      //     BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
      //   }
      // }
      when {
        expression {
          params.executeTests
        }
      }
      steps {
        echo 'testing the application...'
      }
    }
    stage("deploy") {
      steps {
        echo 'deploying the application...'
        // echo "deploying with ${SERVER_CREDENTIALS}"
        // withCredentials([
        //   usernamePassword(credentials: 'my-demo-project', usernameVariable: USER, passwordVariable: PWD)
        // ]) {
        //   sh "some script ${USER} ${PWD}"
        // }
        echo "deploying version ${params.VERSION}"
      }
    }
  }
  
}
