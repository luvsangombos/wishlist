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
        checkout scm
      }
    }

    stage('Build & Deploy') {
      steps {
        dir('wishlist_compose') {
          sh '''
            export DB_USER=$DB_USER
            export DB_PASS=$DB_PASS
            export DB_URL=$DB_URL
            export JWT_SECRET=$JWT_SECRET
            export JWT_EXPIRE=$JWT_EXPIRE
            export MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD

            docker-compose build
            docker-compose down
            docker-compose up -d
          '''
        }
      }
    }

    stage('Logs') {
      steps {
        dir('wishlist_compose') {
          sh 'docker-compose logs --tail=100'
        }
      }
    }
  }
}