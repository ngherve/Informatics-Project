using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class NotifyUser : System.Web.UI.Page
    {
        UserServiceClient client;

        protected void Page_Load(object sender, EventArgs e)
        {
            client = new UserServiceClient();
        }

        protected void btnNotEmpl_Click(object sender, EventArgs e)
        {
            string email = notemail.Value;
            string message = notmessag.Value;
            User us = null;
            User[] users = client.GetAllUsers();
            foreach (User u in users)
            {
                if (u.Email.Equals(email))
                {
                    us = u;
                }
            }
            if (us != null)
            {
                DateTime currenttime = DateTime.Now;
                Notification not = new Notification
                {
                    UserID = us.UserID,
                    Message = message,
                    N_Datetime = currenttime.ToString(),
                    N_Email = "Admin - " + Session["UserEmail"].ToString()
                };
                string sendNot = client.SaveNotif(not);
                Response.Write("<script>alert('Your Notification has been sent Successfully to " + us.Name + "')</script>");

                //string result = DownloadString("http://...")

                //string postData = "var1=1&var2=2&var3=3";
                // Prepare web request...
                //HttpWebRequest myRequest = (HttpWebRequest)WebRequest.Create(
                //                    "https://localhost/script/send_push.php");
                //myRequest.Method = "POST";
                //var resp = (HttpWebResponse)myRequest.GetResponse();

                //var result = new StreamReader(resp.GetResponseStream()).ReadToEnd();
                //var dgurl = "DGURL", user = "DGUSER", pass = "DGPASS";
                var url = string.Format("http://localhost/script/send_push.php");
                using (var webClient = new WebClient())
                {
                    var response = webClient.DownloadString(url);
                    Console.WriteLine(response);
                }
                //Response.Redirect("https://localhost/script/send_push.php");
            }
            else
            {
                Response.Write("<script>alert('Please enter the correct email')</script>");
            }
        }

        protected void btnCancelNot_Click(object sender, EventArgs e)
        {
            Response.Redirect("home.aspx");
        }
    }
}