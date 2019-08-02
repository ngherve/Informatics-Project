using System;
using System.Collections.Generic;
using System.Linq;
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