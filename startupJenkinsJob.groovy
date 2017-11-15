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

folder("simple") { }


pipelineJob('simple/simple_pipeline_job') {
displayName('simple_pipeline_test')
	definition {
	    	cpsScm {
	    		scm {
	    	    	git {
	    	        	remote {
	    	            	name('sdp2')
	    	            	url('https://github.com/alexandershelega/jenkins-sdp2.git')
							credentials('a85736fd-a8d3-4686-9e6a-bc9fe9585767')
	    	            	branch('master')
	    	        	}
	    	    	    }
	   	     	}
	    	    }
		}
	properties {
		buildDiscarder {
			strategy {
				logRotator {
					artifactDaysToKeepStr(1)
					artifactNumToKeepStr(1)
					daysToKeepStr(1)
					numToKeepStr(1)
				}
			}
		}
	}
}
