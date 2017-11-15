folder("test_folder") { }


multibranchPipelineJob('test_folder/test_job') {
   description('test_job')
	branchSources {
        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('b02b56e4-baa6-481c-ab2d-39f7403880e4')
            
        }
	}

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}
