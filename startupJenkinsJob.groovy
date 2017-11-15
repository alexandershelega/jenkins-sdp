folder("test_folder") { }


multibranchPipelineJob('test_folder/test_job') {
   description('test_job')
	branchSources {
        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('a85736fd-a8d3-4686-9e6a-bc9fe9585767')
            
        }
	}

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}
