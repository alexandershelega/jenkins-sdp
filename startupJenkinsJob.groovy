folder("test_folder") { }


multibranchPipelineJob('test_folder/test_job') {
   description('test_job')
	branchSources {
        git {
            remote('https://github.com/alexandershelega/jenkins-sdp2.git')
            credentialsId('8f772c78-46fe-4f49-9599-3c3d4d32ae90')
            
        }
	}

    orphanedItemStrategy {
        discardOldItems {
            daysToKeep(1)
        }
    }
}

folder("analytics") { }


pipelineJob('analytics/analytics_base_images') {
displayName('analytics_base_images')
description('analytics_base_images')	
	definition {
	    	cpsScm {
	    		scm {
	    	    	git {
	    	        	remote {
	    	            	url('https://github.com/PicsArt/pa-docker-analytics-images.git')
				credentials('8f772c78-46fe-4f49-9599-3c3d4d32ae90')
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
					artifactDaysToKeepStr('2')
					artifactNumToKeepStr('2')
					daysToKeepStr('2')
					numToKeepStr('2')
				}
			}
		}
	}
}

pipelineJob('analytics/analytics_node_images') {
displayName('analytics_node_images')
description('analytics_node_images')	
	definition {
	    	cpsScm {
	    		scm {
	    	    	git {
	    	        	remote {
	    	            	url('https://github.com/PicsArt/picsart-analytics.git')
				credentials('8f772c78-46fe-4f49-9599-3c3d4d32ae90')
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
					artifactDaysToKeepStr('2')
					artifactNumToKeepStr('2')
					daysToKeepStr('2')
					numToKeepStr('2')
				}
			}
		}
	}
}
