pipeline {
  agent any
  
  tools {
    maven 'Maven-3.8.4'
  }
  
  stages {
    stage("run backend") {
      steps {
        echo 'excuting maven...'
        sh 'mvn -v'
      }
    }
  }
  
}
