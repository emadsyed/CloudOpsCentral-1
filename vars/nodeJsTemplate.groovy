
import groovy.json.*
 
def dockerfile = readfile libraryResource 'DOCKERFILE'
def getCommitSha(){
    String[] version = sh(returnStdout: true, script: 'git rev-parse --short HEAD')
               //version=$(git rev-parse --short HEAD) | PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]") | PACKAGENAME=${PNAME%.*} | docker build -t adilforms/$PACKAGENAME.$version:$BRANCH_NAME .
//)
 
}
//def getCommitSha(){
  //  String[] version = sh(returnStdout: true, script: """#!/bin/bash -l
  //      git diff-tree --no-commit-id --name-only -r HEAD^..HEAD | grep -E '${regex}'
   // """).split("\n")

def call(Map config) {

 node ('master'){
  //deleteDir()
  try{
  
stage('Checkout'){
 checkout scm  // In this Step Jenkins will get the Git Url and Branch name from the job.
  //def dockerfile = libraryResource 'dockerfilepull.sh' // Reading Docker function to Copy Docker file.
 //sh  dockerfile  
 sh ' echo $dockerfile >> Dockerfile'
 
}
stage('Build'){
 
    echo 'building'

 
    sh 'npm install'
//def builddocker = libraryResource 'dockerBuild.sh'
 //sh builddocker
 
 
}
stage('Test'){ 
 version: getCommitSha()
    echo '$version' 
 }
 
stage('Publish') { 
def request = libraryResource 'dockerPush.sh'
 sh request
 }
stage('PostAction') {
 echo "Email"
   //echo "Cleaning WorkSpace"
   deleteDir()  
  }
   echo "Success"
   return true
   
  
  }
  catch (err){
      echo "Failed"
   throw err
   }

  
  
}
 }

