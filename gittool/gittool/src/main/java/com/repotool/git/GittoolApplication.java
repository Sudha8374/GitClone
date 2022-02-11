package com.repotool.git;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RefSpec;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.repotool.git.model.EntitiesValues;
import com.repotool.git.services.GitService;



@SpringBootApplication
public class GittoolApplication {

	public static void main(String[] args) throws GitAPIException, IOException  {
		    
		/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the branch name : ");
        String branchName = bufferedReader.readLine();
        System.out.println();
		System.out.println();
        System.out.print("Enter your User Id [Example: <USERID>] : ");
        String userName = bufferedReader.readLine();
        System.out.println();
        System.out.print("Enter your Password : ");
        String password = bufferedReader.readLine();
        System.out.println();
        */
        
	        
		SpringApplication.run(GittoolApplication.class, args);
        //GittoolApplication.run(userName, password);
        //findAndReplace();
        
        //createCommit();
        //branchFun(branchName,userName, password);

		
	}
	
	/*public static void run(String userName,String password) throws GitAPIException, IOException
	{
		EntitiesValues entitiesValues = new EntitiesValues(userName, password);
		
		GitService gitService = new GitService();
		gitService.cloneRepository(entitiesValues);
		
		
		
		
	}
	
	public  static void findAndReplace() {
		
		
		String cloneDirectoryPath = "C:\\Cloning2";
		
		GitService gitService = new GitService();
		gitService.recurseOnFile(new File(cloneDirectoryPath));
		  System.out.println("Find and replace done");
	}*/
	
	/*public static void branchFun(String branchName,String userName,String password) throws IOException {
		
		EntitiesValues entitiesValues = new EntitiesValues(userName, password);
		String cloneDirectoryPath = "C:\\Cloning2";
		final String checkoutPath = cloneDirectoryPath + ".git";
		
        GitService.createAndCommitBranch(branchName, checkoutPath,entitiesValues);
        //boolean isNewBranchCreated = GitService.checkoutBranch(branchName, checkoutPath);
        
        

	}*?
	
	/*public static void createCommit() {
		CreateBranchCommand createBranchCommand = null;
		CheckoutCommand checkoutCommand = null;
		Git git ;
		String releaseVersion = "Test";
		PushCommand pushCommand = null;
		StoredConfig config = null;
		String cloneDirectoryPath = "C:\\Cloning2";
		File src = new File(cloneDirectoryPath);
		try {
		// Consider Git object is created 
		//git = createGitObject();
			Repository repo = new FileRepositoryBuilder().readEnvironment().findGitDir(src).build();
            git = new Git(repo);

		// Checkout Release branch 
		checkoutCommand = git.checkout();
		checkoutCommand.setName("master");
		checkoutCommand.call();

		// Creating Hotfix Branch 
		createBranchCommand = git.branchCreate();
		createBranchCommand.setName("sample_" + releaseVersion).call();
		createBranchCommand.setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM);
		createBranchCommand.setStartPoint("origin/" + "sample_" + releaseVersion);
		createBranchCommand.setForce(true);
		createBranchCommand.call();

		//Pushing Hotfix Branch to remote
		 //note that the hotfix is not present in remote 
		 
		pushCommand = git.push();
		pushCommand.setRemote("origin");
		pushCommand.setRefSpecs(new RefSpec("sample_" + releaseVersion + ":sample_" + releaseVersion));
		pushCommand.call();

		

		// Editing the configuration file in local 
		config = git.getRepository().getConfig();
		config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, "sample_" + releaseVersion, "remote", "origin");
		config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, "sample_" + releaseVersion, "merge",
		    "C:\\Cloning2\\sample_" + releaseVersion);
		config.save();
		} catch (Exception exception) {
		exception.printStackTrace();
		}

	}*/
	
	
	

}
