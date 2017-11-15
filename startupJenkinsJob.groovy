folder("test_folder") { }


PipelineJob('test_folder/test_job') {
   description('test_job')

        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('7df4f184-e3f6-4ff5-88a6-5087f907d57f ')
        }

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}
