package in.anandm.apps.template.application.impl;

import static org.junit.Assert.assertTrue;
import in.anandm.apps.template.domain.helper.ISecurityContextHelper;
import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;
import in.anandm.apps.template.domain.model.permission.Permission;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * The class <code>AuthorizationServiceTest</code> contains tests for the class <code>{@link AuthorizationService}</code>.
 *
 * @generatedBy CodePro at 6/6/14 4:07 PM
 * @author anandm
 * @version $Revision: 1.0 $
 */
public class AuthorizationServiceTest {

	private static ISecurityContextHelper securityContextHelper;

	/**
	 * Run the boolean isAuthorized(ModulePermissionConstants) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	@Test
	public void testIsAuthorized_1()
			throws Exception {

		Mockito.when(securityContextHelper.getAuthorities()).thenReturn(new ArrayList<Authority>());

		AuthorizationService fixture = new AuthorizationService(securityContextHelper);
		ModulePermissionConstants modulePermission = ModulePermissionConstants.USER_ADD;

		boolean result = fixture.isAuthorized(modulePermission);


		assertTrue(!result);
	}

	/**
	 * Run the boolean isAuthorized(ModulePermissionConstants) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	@Test
	public void testIsAuthorized_2()
			throws Exception {

		List<Authority> authorities = new ArrayList<Authority>();
		Authority authority = new Authority("userRole");

		authority.addPermission(ModulePermissionConstants.USER_ADD.asPermission());
		authorities.add(authority);

		Mockito.when(securityContextHelper.getAuthorities()).thenReturn(authorities);
		AuthorizationService fixture = new AuthorizationService(securityContextHelper);
		ModulePermissionConstants modulePermission = ModulePermissionConstants.USER_ADD;

		boolean result = fixture.isAuthorized(modulePermission);


		assertTrue(result);
	}

	/**
	 * Run the boolean isAuthorized(ModulePermissionConstants) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	@Test
	public void testIsAuthorized_3()
			throws Exception {

		List<Authority> authorities = new ArrayList<Authority>();
		Authority authority = new Authority("userRole");

		authority.addPermission(new Permission("unlknown", "unknown"));
		authorities.add(authority);

		Mockito.when(securityContextHelper.getAuthorities()).thenReturn(authorities);

		AuthorizationService fixture = new AuthorizationService(securityContextHelper);
		ModulePermissionConstants modulePermission = ModulePermissionConstants.USER_ADD;

		boolean result = fixture.isAuthorized(modulePermission);


		assertTrue(!result);
	}


	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	@Before
	public void setUp()
			throws Exception {
		securityContextHelper = Mockito.mock(ISecurityContextHelper.class);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	@After
	public void tearDown()
			throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 6/6/14 4:07 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(AuthorizationServiceTest.class);
	}
}