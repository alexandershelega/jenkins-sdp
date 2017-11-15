folder("test_folder") { }


pipelineJob('test_folder/test_job') {
   description('test_job')

branchSources {
        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('7df4f184-e3f6-4ff5-88a6-5087f907d57f ')
	    include('master')
        }
}

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}
