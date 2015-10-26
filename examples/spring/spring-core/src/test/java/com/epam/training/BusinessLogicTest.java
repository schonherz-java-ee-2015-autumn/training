package com.epam.training;

import org.junit.Test;

import com.epam.training.spring.common.DatabaseResource;
import com.epam.training.spring.common.NetworkResource;
import com.epam.training.spring.xmlconfig.BusinessLogicImpl;

import static org.mockito.Mockito.*;

public class BusinessLogicTest {
	
	@Test
	public void shouldSaveToDatabase() {
		// test when downloaded content contains 1
		NetworkResource server = mock(NetworkResource.class);
		DatabaseResource database = mock(DatabaseResource.class);
		
		BusinessLogicImpl businessLogic = new BusinessLogicImpl();
		businessLogic.setServer(server);
		businessLogic.setDatabase(database);
		
		doReturn("network content 1").when(server).downloadFileContents(anyString());
		
		businessLogic.doBusiness("somepath");
		
		verify(server).downloadFileContents(anyString());
		verify(database).saveContentToDatabase("network content 1");
		
		verifyNoMoreInteractions(server, database);
	}
	
	@Test
	public void shouldSaveToServer() {
		// test when downloaded content contains 2
		NetworkResource server = mock(NetworkResource.class);
		DatabaseResource database = mock(DatabaseResource.class);
		
		BusinessLogicImpl businessLogic = new BusinessLogicImpl();
		businessLogic.setServer(server);
		businessLogic.setDatabase(database);
		
		doReturn("network content 2").when(server).downloadFileContents(anyString());
		doReturn("database content 2").when(database).getContentFromDatabase();
		
		businessLogic.doBusiness("somepath");
		
		verify(server).downloadFileContents(anyString());
		verify(database).getContentFromDatabase();
		verify(server).uploadFileContent(anyString(), eq("database content 2"));
		
		verifyNoMoreInteractions(server, database);
	}
	
	
	@Test
	public void shouldDoNothing() {
		// test when downloaded content has no 1 or 2
		NetworkResource server = mock(NetworkResource.class);
		DatabaseResource database = mock(DatabaseResource.class);
		
		BusinessLogicImpl businessLogic = new BusinessLogicImpl();
		businessLogic.setServer(server);
		businessLogic.setDatabase(database);
		
		doReturn("network content 3").when(server).downloadFileContents(anyString());
		
		businessLogic.doBusiness("somepath");
		
		verify(server).downloadFileContents(anyString());
		
		verifyNoMoreInteractions(server, database);
	}
	
}
