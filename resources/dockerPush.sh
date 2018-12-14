    # arg $1 is "repo/packageName.version:branchName"
    ljljjlljjkklk
      echo "Publishing..."
      #docker push $1
      version=$(git rev-parse --short HEAD)
      PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
      PACKAGENAME=${PNAME%.*}
      docker push adilforms/$PACKAGENAME.$version:$BRANCH_NAME
