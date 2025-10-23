pipeline {
  agent any

  environment {
    COMPOSE_FILE = 'docker-compose.yml'
    DB_USER = credentials('DB_USER')
    DB_PASS = credentials('DB_PASS')
    DB_URL = credentials('DB_URL')
    JWT_SECRET = credentials('JWT_SECRET')
    JWT_EXPIRE = credentials('JWT_EXPIRE')
    MYSQL_ROOT_PASSWORD = credentials('MYSQL_ROOT_PASSWORD')
  }

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/luvsangombos/wishlist.git'
      }
    }

    stage('Build') {
      steps {
        sh 'docker-compose build'
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker-compose down'
        sh 'docker-compose up -d'
      }
    }
  }
}