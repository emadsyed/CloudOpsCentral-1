package version {

def getLatestBuildDetails(context){
    //...
    executeCommand(context, 'git rev-parse HEAD')
    //...
}

def executeCommand(context, String command) {
    stdout = script.sh(script: command, returnStdout: true)
    return stdout.trim()
}
return this
}


