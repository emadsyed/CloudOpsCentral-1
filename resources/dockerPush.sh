    # arg $1 is "repo/packageName.version:branchName"
      echo "Publishing..."
      docker push $1
