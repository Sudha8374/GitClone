package com.repotool.git.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("config")
public class ConfigGit {

	private String giturl;

	public String getGiturl() {
		return giturl;
	}

	public void setGiturl(String giturl) {
		this.giturl = giturl;
	}
	

}
