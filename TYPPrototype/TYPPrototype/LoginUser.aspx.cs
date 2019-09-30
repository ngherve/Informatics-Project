using System;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class LoginUser : System.Web.UI.Page
    {
        UserServiceClient usrclient;

        protected void Page_Load(object sender, EventArgs e)
        {
            if(Session["Username"] != null)
            {
                Response.Redirect("dashboard.aspx");
            }
        }
        protected void btnLogin_Click(object sender, EventArgs e)
        {
            string usernam = username.Value;
            string Password = Secrecy.HashPassword(userpassword.Value);

            usrclient = new UserServiceClient();

            if (Session["Username"] == null)
            {
                if(usrclient.LoginUser(usernam, Password) == true)
                {
                    Session["Username"] = usernam;
                    Response.Redirect("dashboard.aspx");
                }
                else
                {
                    error.InnerHtml = "Error: Invalid Credentials";
                    Session["Username"] = null;
                }
            }
        }
    }
}