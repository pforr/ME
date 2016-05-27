package vn.dtt.cmon.user.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil;
import vn.dtt.sol.ns.util.MessageErrors;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.usersadmin.util.UsersAdmin;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;

public class UserMappingAction {

	public static final String ID = "id";
	public static final String USER_ID = "userId";
	public static final String USER_TYPE = "typeUser";
	public static final String ORG_CODE1 = "orgCode1";
	public static final String ORG_CODE2 = "orgCode2";

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addUserMapping(ActionRequest request, ActionResponse response)
			throws Exception {

		User user = addUserLiferay(request);

		long id = ParamUtil.getLong(request, ID);
		long userId = 0;

		if (Validator.isNotNull(user)) {
			userId = user.getUserId();
		}

		String maTinh = ParamUtil.getString(request, "capTinh");
		String maHuyen = ParamUtil.getString(request, "capHuyen");
		String maTram = ParamUtil.getString(request, "capTram");

		int typeUser = ParamUtil.getInteger(request, USER_TYPE);
		String orgCode1 = StringPool.BLANK;
		String orgCode2 = StringPool.BLANK;

		if (typeUser == 1) {
			orgCode1 = StringPool.BLANK;
			orgCode2 = StringPool.BLANK;
		} else if (typeUser == 2) {
			orgCode1 = maTinh;
			orgCode2 = StringPool.BLANK;
		} else if (typeUser == 3) {
			orgCode1 = maTinh;
			orgCode2 = maHuyen;
		} else if (typeUser == 4) {
			orgCode1 = maTinh;
			orgCode2 = maTram;
		}

		String firstName = ParamUtil.getString(request, "fullName");

		String cmd = ParamUtil.getString(request, Constants.CMD);

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(userId, typeUser, errors);

		if (valid) {
			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {

				UserMappingLocalServiceUtil.addUserMapping(id, firstName,
						userId, typeUser, orgCode1, orgCode2);

				SessionMessages.add(request, "usermapping-saved-successfully");
			}
		}

		if (errors.size() != 0) {
			for (String error : errors) {
				SessionMessages.add(request, error);
			}
		}
	}

	/**
	 * @param actionRequest
	 * @return
	 */
	protected User addUserLiferay(ActionRequest actionRequest) {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		User user = null;

		long userId = ParamUtil.getLong(actionRequest, "userId");


		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(vn.dtt.sol.ns.util.WebKeys.THEME_DISPLAY);

		boolean autoPassword = ParamUtil.getBoolean(actionRequest,
				"autoPassword", false);

		String password1 = actionRequest.getParameter("password1");
		String password2 = actionRequest.getParameter("password2");

		String reminderQueryQuestion = ParamUtil.getString(actionRequest,
				"reminderQueryQuestion");

		if (reminderQueryQuestion.equals(UsersAdmin.CUSTOM_QUESTION)) {
			reminderQueryQuestion = ParamUtil.getString(actionRequest,
					"reminderQueryCustomQuestion");
		}

		boolean autoScreenName = ParamUtil.getBoolean(actionRequest,
				"autoScreenName");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");
		long facebookId = 0;
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "fullName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);

		Calendar cal = Calendar.getInstance();

		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);

		//
		// int birthdayMonth = ParamUtil
		// .getInteger(actionRequest, "birthdayMonth");
		// int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		// int birthdayYear = ParamUtil.getInteger(actionRequest,
		// "birthdayYear");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = getLongArray(actionRequest,
				"groupsSearchContainerPrimaryKeys");
		long[] organizationIds = getLongArray(actionRequest,
				"organizationsSearchContainerPrimaryKeys");
		long[] roleIds = getLongArray(actionRequest,
				"rolesSearchContainerPrimaryKeys");
		long[] userGroupIds = getLongArray(actionRequest,
				"userGroupsSearchContainerPrimaryKeys");
		List<Address> addresses = UsersAdminUtil.getAddresses(actionRequest);
		List<EmailAddress> emailAddresses = UsersAdminUtil
				.getEmailAddresses(actionRequest);
		List<Phone> phones = UsersAdminUtil.getPhones(actionRequest);
		List<Website> websites = UsersAdminUtil.getWebsites(actionRequest);
		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<AnnouncementsDelivery>();
		boolean sendEmail = true;

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);
			if (cmd.contentEquals(Constants.ADD)) {
				user = UserServiceUtil.addUser(themeDisplay.getCompanyId(),
						autoPassword, password1, password2, autoScreenName,
						screenName, emailAddress, facebookId, openId,
						LocaleUtil.getDefault(), firstName, middleName,
						lastName, prefixId, suffixId, male, birthdayMonth,
						birthdayDay, birthdayYear, jobTitle, groupIds,
						organizationIds, roleIds, userGroupIds, addresses,
						emailAddresses, phones, websites,
						announcementsDeliveries, sendEmail, serviceContext);

			} else if (cmd.contentEquals(Constants.UPDATE)) {
				
				try {
					user = UserLocalServiceUtil.getUser(userId);
				} catch (Exception e) {
				}
				
				user = UserServiceUtil.updateUser(userId, user.getPassword(),
						StringPool.BLANK, StringPool.BLANK, false,
						reminderQueryQuestion, user.getReminderQueryAnswer(),
						screenName, emailAddress, facebookId, openId,
						user.getLanguageId(), user.getTimeZone().getID(),
						user.getGreeting(), user.getComments(), firstName,
						middleName, lastName, prefixId, suffixId, male,
						birthdayMonth, birthdayDay, birthdayYear,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, jobTitle, groupIds, organizationIds,
						roleIds, new ArrayList<UserGroupRole>(), userGroupIds,
						addresses, emailAddresses, phones, websites,
						announcementsDeliveries, serviceContext);

			}

		} catch (Exception e) {
			_log.error(e);
		}

		return user;
	}

	/**
	 * @param portletRequest
	 * @param name
	 * @return
	 */
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}

	/**
	 * @param userId
	 * @param userType
	 * @param errors
	 * @return
	 */
	private boolean validationInput(long userId, int userType,
			List<String> errors) {

		boolean result = true;

		if (userId == 0) {
			errors.add(MessageErrors.EMPTY_USER_LIFERAY);
			result = false;
		}

		if (userType == 0) {
			errors.add(MessageErrors.EMPTY_USER_TYPE);
			result = false;
		}

		return result;
	}

	private static Log _log = LogFactoryUtil.getLog(UserMappingAction.class);

}
