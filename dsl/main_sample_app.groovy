multibranchPipelineJob("target-app") {
  branchSources {
    github {
      apiUri('https://api.github.com')
      buildForkPRHead(false)
      buildForkPRMerge(false)
      buildOriginBranch(true)
      buildOriginBranchWithPR(true)
      buildOriginPRHead(false)
      buildOriginPRMerge(true)
      checkoutCredentialsId('github-user')
      scanCredentialsId('github-user')
      repoOwner('makmk')
      repository('softwaremill-app')
      id('target-app-branch')
    }
  }
  factory {
    workflowBranchProjectFactory {
      scriptPath('Jenkinsfile')
    }
  }
  orphanedItemStrategy {
    defaultOrphanedItemStrategy {
      pruneDeadBranches(true)
      daysToKeepStr("5")
      numToKeepStr("20")
      
    }
  }
}
