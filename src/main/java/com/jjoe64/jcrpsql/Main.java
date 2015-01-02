package com.jjoe64.jcrpsql;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by jonas on 02.01.15.
 */
public class Main {
	public static void main(String[] args) throws RepositoryException {
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new GuestCredentials());
		try {
			String user = session.getUserID();
			String name = repository.getDescriptor(Repository.REP_NAME_DESC);
			System.out.println(
					"Logged in as " + user + " to a " + name + " repository.");
		} finally {
			session.logout();
		}
	}
}
