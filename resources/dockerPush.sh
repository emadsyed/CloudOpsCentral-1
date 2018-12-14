    # arg $1 is "repo/packageName.version:branchName"
      echo "Publishing..."
      #docker push $1
      PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
      PACKAGENAME=${PNAME%.*}
      docker push adilforms/$PACKAGENAME.$version:$BRANCH_NAME
