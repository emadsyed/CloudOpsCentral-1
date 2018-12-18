

    def PACKAGENAME = '''
       version=$(git rev-parse --short HEAD)
       PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
       PACKAGENAME=${PNAME%.*}
       echo $PACKAGENAME
                   '''

       def proc = ['bash', '-c', PACKAGENAME].execute()
       proc.waitFor()
    return proc.text
       
       */

def call(Map config) {
 
 node ('master'){
  try{
         
 stage('Checkout'){
 checkout scm  
      }

stage('Build'){
 
    echo 'building'
// executeShellCommand(command)
   
    sh 'npm install'
// def artifactname = libraryResource 'dockerImageName.sh'
 //sh artifactname

 
}
stage('Test'){ 
    echo 'version' 
 }
 
stage('Publish') { 
def request = libraryResource 'dockerPush.sh'
 sh request
 }
stage('PostAction') {
   echo "Cleaning WorkSpace"
   deleteDir()
    echo "Sending Email'
    emailext body: ""HELLO,
        Email test"", subject: 'Testing Email', to: 'emad.syed@careebuilder.com'
    
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


