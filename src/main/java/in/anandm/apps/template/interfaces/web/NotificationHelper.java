/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author anandm
 *
 */
@Component
public class NotificationHelper {

	private static final String  NOTIFICATION_ATTR = "notifications";

	public static final void notify(Notification notification){
		
		@SuppressWarnings("unchecked")
		ArrayList<Notification> notifications =  (ArrayList<Notification>) RequestContextHolder.getRequestAttributes().getAttribute(NOTIFICATION_ATTR, ServletRequestAttributes.SCOPE_SESSION);

		if(notifications == null){
			notifications =  new ArrayList<Notification>();
		}
		
		notifications.add(notification);
		RequestContextHolder.getRequestAttributes().setAttribute(NOTIFICATION_ATTR,notifications, ServletRequestAttributes.SCOPE_SESSION);
		
		
	}
}
