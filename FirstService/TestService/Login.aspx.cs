using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TestService.LoginService;

namespace TestService
{
    public partial class Login : System.Web.UI.Page
    {
        IloginRegClient client = new IloginRegClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnLOgin_Click(object sender, EventArgs e)
        {
            var Username = username.Value;
            var Pass = Secrecy.HashPassword(password.Value);
            Boolean loggedin = client.Login(Username, Pass);

            if (loggedin == true)
            {
                Session["loggedin"] = true;
                Response.Redirect("Home.aspx");
            }
            else
            {
                report.InnerHtml = "<p> Incorrect Username or Password </p>";
            }
        }
    }
}