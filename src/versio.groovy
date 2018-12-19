def version = sh( script: 'git rev-parse --short HEAD > short-git-sha.tmp', returnStdout: true).toString().trim()
    echo 'using new version ' +  version
    return version
