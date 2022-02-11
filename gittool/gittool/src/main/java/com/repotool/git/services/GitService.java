package com.repotool.git.services;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repotool.git.configuration.ConfigGit;
import com.repotool.git.model.EntitiesValues;




@Service
public class GitService {
	
	@Autowired
	ConfigGit config;
	
	public void cloneRepository(String sourceBranch)
	{
		
		System.out.println(config.getGiturl());
		String repoUrl = "https://github.training.cerner.com/ob095866/Test1.git";
		String cloneDirectoryPath = "C:\\Cloning2"; // Ex.in windows c:\\gitProjects\SpringBootMongoDbCRUD\
		
		try {
		    System.out.println("Cloning "+repoUrl+" into "+cloneDirectoryPath);
		    Git.cloneRepository()
		        .setURI(repoUrl)
		        .setDirectory(Paths.get(cloneDirectoryPath).toFile())
		        .setCredentialsProvider((new UsernamePasswordCredentialsProvider("ob095866", "Umadevi@1506")))
		        .call();
		    System.out.println("Completed Cloning");
		} catch (GitAPIException e) {
		    System.out.println("Exception occurred while cloning repo");
		    e.printStackTrace();
		}
		
	}
	
	//recursing folder inside a folder getting the list of all files in all folders
	public  void recurseOnFile(String path) {
		
		  File passedFile = new File(path);
		  if (passedFile.isFile()) {
		    replaceInFile(passedFile);
		  }else if (passedFile.isDirectory()) {
		     File[] listOfFiles = passedFile.listFiles();
		    for (File inDir : listOfFiles) {
		    	
		    	if(!inDir.isHidden())
		    	{
		    		recurseOnFile(inDir.getAbsolutePath());	
		    	}
		      
		    }
		  }
		}
	
	//from the list of all files finding and replacing the key words
	private void replaceInFile(File file)
	{
		try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();

            String replacedtext = oldtext.replaceAll("<eol> ", "");
            replacedtext = replacedtext.replaceAll("UNIVERSALHS_MILLENNIUM", "UNIVERSALHS_EDW_MILL_CDS");
            
            

            FileWriter writer = new FileWriter(file);
            writer.write(replacedtext);

            writer.close();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
		
	}
	
	
		public  boolean createAndCommitBranch(final String destinationBranchName) {
			
			
			String cloneDirectoryPath = "C:\\Cloning2";
			CheckoutCommand checkout;
	        Git git;
	  
	        File src = new File(cloneDirectoryPath);
	        
            
	        try {
	        	
	        	Repository repo = new FileRepositoryBuilder().readEnvironment().findGitDir(src).build();
	            git = new Git(repo);
	            git.branchCreate().setName(destinationBranchName).call();
	            checkout = git.checkout();
	            checkout.setName(destinationBranchName);
	            checkout.call();
	            //git.add();
	            git.commit().setAll(true).setMessage("replacement done").call();
	            
	           
	        	
	        	/*git=Git.open(new File("C:\\Cloning2"));
	        	git.branchCreate().setName(destinationBranchName).call();
	        	git.add();
	        	git.commit().setMessage("Schema replaced").call();
	        	checkout = git.checkout();
	        	checkout.setName(destinationBranchName);
	            checkout.call();*/
	        	
	        	/*
	            Repository repo = new FileRepositoryBuilder().readEnvironment().findGitDir(src).build();
	            git = new Git(repo);
	            git.branchCreate().setName(destinationBranchName).call();
	            checkout = git.checkout();
	            //recurseOnFile(cloneDirectoryPath);
	            checkout.setName(destinationBranchName);
	            checkout.call();*/
	            
	            System.out.println("New Branch created");
	           
	            PushCommand pushCommand = git.push();
	            pushCommand.setRemote("origin");
	            pushCommand.setRefSpecs(new RefSpec(destinationBranchName + ":" + destinationBranchName));
	            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(
	                    "ob095866", "Umadevi@1506"));
	            pushCommand.call();
	            System.out.println("pushed successfully");
	            return true;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
	
		
	}
	

