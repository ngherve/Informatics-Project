using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TestService.LoginService;

namespace TestService
{
    public partial class Register : System.Web.UI.Page
    {
        IloginRegClient client = new IloginRegClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            

        }

        protected void btnReg_Click(object sender, EventArgs e)
        {
            string output = "";
            if (password.Value == password1.Value)
            {
                string pass = Secrecy.HashPassword(password.Value);
                output = client.Register(title.Value, name.Value, surname.Value, email.Value,username.Value, pass);
            }

            if (output.Equals("Success"))
            {
                report.InnerHtml = "<p>" + output + "</p>";
            }
            report.InnerHtml = "<p>" + output +"</p>";
        }
    }
}