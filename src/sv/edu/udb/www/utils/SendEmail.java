package sv.edu.udb.www.utils;

import java.util.Properties; 
import java.util.logging.*;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	public  String sendEmpresaVerificationEmail(String destino, String nombre) throws MessagingException {
		Token newTokem = new Token();
		String generatedTokemString = newTokem.token();
		String destinatario = destino;
		String nombreEmpresa = nombre;
         
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");

		final String myAccountEmail = "cuponeradwf@gmail.com";
		final String password = "bhcyhewgsqaledwh";
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		Message message = prepareMessage(session, password, destinatario, generatedTokemString, nombreEmpresa);
		if(message == null) {
			return "";
		}else {
	    Transport.send(message);
	       return generatedTokemString;
		}
	
	}
	private static Message prepareMessage(Session session, String myAcountString, String destinatario, String tokem, String nombreEmpresa) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAcountString));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject("Codigo de verificacion");
			message.setContent(
					"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
					+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
					+ "<head>\r\n"
					+ "<!--[if gte mso 9]>\r\n"
					+ "<xml>\r\n"
					+ "  <o:OfficeDocumentSettings>\r\n"
					+ "    <o:AllowPNG/>\r\n"
					+ "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
					+ "  </o:OfficeDocumentSettings>\r\n"
					+ "</xml>\r\n"
					+ "<![endif]-->\r\n"
					+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "  <meta name=\"x-apple-disable-message-reformatting\">\r\n"
					+ "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n"
					+ "  <title></title>\r\n"
					+ "  \r\n"
					+ "    <style type=\"text/css\">\r\n"
					+".myButton {\r\n"
					+ "	box-shadow:inset 0px 1px 0px 0px #cf866c;\r\n"
					+ "	background:linear-gradient(to bottom, #d0451b 5%, #bc3315 100%);\r\n"
					+ "	background-color:#d0451b;\r\n"
					+ "	border-radius:3px;\r\n"
					+ "	border:1px solid #942911;\r\n"
					+ "	display:inline-block;\r\n"
					+ "	cursor:pointer;\r\n"
					+ "	color:#ffffff;\r\n"
					+ "	font-family:Arial;\r\n"
					+ "	font-size:15px;\r\n"
					+ "	padding:5px 40px;\r\n"
					+ "	text-decoration:none;\r\n"
					+ "	text-shadow:0px 1px 0px #854629;\r\n"
					+ "}\r\n"
					+ ".myButton:hover {\r\n"
					+ "	background:linear-gradient(to bottom, #bc3315 5%, #d0451b 100%);\r\n"
					+ "	background-color:#bc3315;\r\n"
					+ "}\r\n"
					+ ".myButton:active {\r\n"
					+ "	position:relative;\r\n"
					+ "	top:1px;\r\n"
					+ "}"
					+ "      table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_social_2 .v-container-padding-padding { padding: 30px 0px !important; } #u_content_heading_3 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_heading_3 .v-text-align { text-align: center !important; } #u_content_text_1 .v-container-padding-padding { padding: 10px 1px 60px 10px !important; } #u_content_text_1 .v-text-align { text-align: center !important; } #u_content_heading_1 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_heading_1 .v-text-align { text-align: center !important; } #u_content_social_1 .v-container-padding-padding { padding: 30px 0px !important; } }\r\n"
					+ "@media only screen and (min-width: 570px) {\r\n"
					+ "  .u-row {\r\n"
					+ "    width: 550px !important;\r\n"
					+ "  }\r\n"
					+ "  .u-row .u-col {\r\n"
					+ "    vertical-align: top;\r\n"
					+ "  }\r\n"
					+ "\r\n"
					+ "  .u-row .u-col-50 {\r\n"
					+ "    width: 275px !important;\r\n"
					+ "  }\r\n"
					+ "\r\n"
					+ "  .u-row .u-col-100 {\r\n"
					+ "    width: 550px !important;\r\n"
					+ "  }\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "@media (max-width: 570px) {\r\n"
					+ "  .u-row-container {\r\n"
					+ "    max-width: 100% !important;\r\n"
					+ "    padding-left: 0px !important;\r\n"
					+ "    padding-right: 0px !important;\r\n"
					+ "  }\r\n"
					+ "  .u-row .u-col {\r\n"
					+ "    min-width: 320px !important;\r\n"
					+ "    max-width: 100% !important;\r\n"
					+ "    display: block !important;\r\n"
					+ "  }\r\n"
					+ "  .u-row {\r\n"
					+ "    width: calc(100% - 40px) !important;\r\n"
					+ "  }\r\n"
					+ "  .u-col {\r\n"
					+ "    width: 100% !important;\r\n"
					+ "  }\r\n"
					+ "  .u-col > div {\r\n"
					+ "    margin: 0 auto;\r\n"
					+ "  }\r\n"
					+ "}\r\n"
					+ "body {\r\n"
					+ "  margin: 0;\r\n"
					+ "  padding: 0;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "table,\r\n"
					+ "tr,\r\n"
					+ "td {\r\n"
					+ "  vertical-align: top;\r\n"
					+ "  border-collapse: collapse;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "p {\r\n"
					+ "  margin: 0;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ ".ie-container table,\r\n"
					+ ".mso-container table {\r\n"
					+ "  table-layout: fixed;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "* {\r\n"
					+ "  line-height: inherit;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "a[x-apple-data-detectors='true'] {\r\n"
					+ "  color: inherit !important;\r\n"
					+ "  text-decoration: none !important;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "</style>\r\n"
					+ "  \r\n"
					+ "  \r\n"
					+ "\r\n"
					+ "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
					+ "\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ffffff;color: #000000\">\r\n"
					+ "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\r\n"
					+ "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n"
					+ "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ffffff;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "  <tr style=\"vertical-align: top\">\r\n"
					+ "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
					+ "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #c8e6f8;\"><![endif]-->\r\n"
					+ "    \r\n"
					+ "\r\n"
					+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #ffffff\">\r\n"
					+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #00113f;\">\r\n"
					+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
					+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #ffffff;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #00113f;\"><![endif]-->\r\n"
					+ "      \r\n"
					+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
					+ "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\r\n"
					+ "  <div style=\"width: 100% !important;\">\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
					+ "  \r\n"
					+ "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #fcfcfc; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: arial,helvetica,sans-serif; font-size: 31px;\">\r\n"
					+ "    Cuponera SA.SV\r\n"
					+ "  </h1>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
					+ "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\r\n"
					+ "  <div style=\"width: 100% !important;\">\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
					+ "  \r\n"
					+ "<table id=\"u_content_social_2\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 0px 30px 90px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "<div align=\"center\">\r\n"
					+ "  <div style=\"display: table; max-width:140px;\">\r\n"
					+ "  <!--[if (mso)|(IE)]><table width=\"140\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:140px;\"><tr><![endif]-->\r\n"
					+ "  \r\n"
					+ "    \r\n"
					+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n"
					+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\r\n"
					+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
					+ "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\r\n"
					+ "          <img src=\"https://toppng.com/uploads/preview/facebook-logo-11549681668z1ra1h6mmx.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
					+ "        </a>\r\n"
					+ "      </td></tr>\r\n"
					+ "    </tbody></table>\r\n"
					+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "    \r\n"
					+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n"
					+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\r\n"
					+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
					+ "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\r\n"
					+ "          <img src=\"https://i2.wp.com/hipertextual.com/wp-content/uploads/2012/06/twitter-bird-white-on-blue.jpg?fit=300%2C300&ssl=1\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
					+ "        </a>\r\n"
					+ "      </td></tr>\r\n"
					+ "    </tbody></table>\r\n"
					+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "    \r\n"
					+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\r\n"
					+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\r\n"
					+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
					+ "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\r\n"
					+ "          <img src=\"https://www.vectorico.com/wp-content/uploads/2018/02/LinkedIn-Icon-squircle.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
					+ "        </a>\r\n"
					+ "      </td></tr>\r\n"
					+ "    </tbody></table>\r\n"
					+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "    \r\n"
					+ "    \r\n"
					+ "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
					+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #185bc5;\">\r\n"
					+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-image: url('https://img.freepik.com/free-vector/overlapping-forms-wallpaper-concept_23-2148650921.jpg?size=626&ext=jpg');background-repeat: no-repeat;background-position: center top;background-color: transparent;\">\r\n"
					+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-image: url('images/image-5.jpeg');background-repeat: no-repeat;background-position: center top;background-color: #185bc5;\"><![endif]-->\r\n"
					+ "      \r\n"
					+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
					+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\r\n"
					+ "  <div style=\"width: 100% !important;\">\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
					+ "  \r\n"
					+ "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 0px 10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 5px solid #0e71ad;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
					+ "    <tbody>\r\n"
					+ "      <tr style=\"vertical-align: top\">\r\n"
					+ "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
					+ "          <span>&#160;</span>\r\n"
					+ "        </td>\r\n"
					+ "      </tr>\r\n"
					+ "    </tbody>\r\n"
					+ "  </table>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "<table id=\"u_content_heading_3\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 10px 15px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 36px;\">\r\n"
					+ "    <strong>Gracias por registrarte con nosotros "+nombreEmpresa+" .</strong>\r\n"
					+ "  </h1>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "<table id=\"u_content_text_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 20px 60px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 210%; text-align: left; word-wrap: break-word;\">\r\n"
					+ "    <p style=\"font-size: 14px; line-height: 210%;\"><span style=\"font-family: Cabin, sans-serif; font-size: 18px; line-height: 37.8px;\">Este es tu codigo de verificacion, ingresalo para poder completar el registro.</span></p>\r\n"
					+ "  </div>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
					+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\r\n"
					+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
					+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\r\n"
					+ "      \r\n"
					+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
					+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\r\n"
					+ "  <div style=\"width: 100% !important;\">\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
					+ "  \r\n"
					+ "<table id=\"u_content_heading_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"1\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:50px 44px 15px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n" 
					+ "        \r\n"
					+ "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #00113f; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 28px;\">\r\n"
					+ "    <strong>Su codigo de verificacion <br /> <p> "+tokem+" </p><br />Puedes ingresar haciendo click en el siguiente boton<br /><a href=\"http://localhost:8080/Desafio1_DWF/empresas/empresas.do?op=completarValidar&userToken="+tokem+"\" class=\"myButton\">Click aqui</a> </strong>\r\n"
					+ "  </h1>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
					+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #303030;\">\r\n"
					+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
					+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #303030;\"><![endif]-->\r\n"
					+ "      \r\n"
					+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
					+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\r\n"
					+ "  <div style=\"width: 100% !important;\">\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
					+ "  \r\n"
					+ "<table id=\"u_content_social_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 0px 20px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 4px solid #ba372a;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
					+ "    <tbody>\r\n"
					+ "      <tr style=\"vertical-align: top\">\r\n"
					+ "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\r\n"
					+ "          <span>&#160;</span>\r\n"
					+ "        </td>\r\n"
					+ "      </tr>\r\n"
					+ "    </tbody>\r\n"
					+ "  </table>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 50px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\r\n"
					+ "        \r\n"
					+ "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 210%; text-align: center; word-wrap: break-word;\">\r\n"
					+ "    <p style=\"font-size: 14px; line-height: 210%;\"><span style=\"font-family: Cabin, sans-serif; font-size: 16px; line-height: 33.6px;\">Universidad Don Bosco 2021</span></p>\r\n"
					+ "<p style=\"font-size: 14px; line-height: 210%;\"><span style=\"font-family: Cabin, sans-serif; font-size: 16px; line-height: 33.6px;\">&copy;20XX La cuponera | San Salvador, El Salvador</span></p>\r\n"
					+ "  </div>\r\n"
					+ "\r\n"
					+ "      </td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "\r\n"
					+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
					+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n"
					+ "    </td>\r\n"
					+ "  </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "  </table>\r\n"
					+ "  <!--[if mso]></div><![endif]-->\r\n"
					+ "  <!--[if IE]></div><![endif]-->\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>\r\n"
					+ "",
					"text/html"
					);
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
