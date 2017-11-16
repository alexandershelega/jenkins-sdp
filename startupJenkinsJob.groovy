folder("test_folder") { }


multibranchPipelineJob('test_folder/test_job') {
   description('test_job')
	branchSources {
        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('860e5e82-b53e-4595-a22f-9db9e05a0640')
            
        }
	}

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}

folder("analytics") { }


pipelineJob('analytics/analytics_basic_images') {
displayName('analytics_basic_images')
description('analytics_basic_images')	
	definition {
	    	cpsScm {
	    		scm {
	    	    	git {
	    	        	remote {
	    	            	name('analytics_basic_images')
	    	            	url('https://github.com/PicsArt/pa-docker-analytics-images.git')
				credentials('860e5e82-b53e-4595-a22f-9db9e05a0640')
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
					artifactDaysToKeepStr('1')
					artifactNumToKeepStr('1')
					daysToKeepStr('1')
					numToKeepStr('1')
				}
			}
		}
	}
}
