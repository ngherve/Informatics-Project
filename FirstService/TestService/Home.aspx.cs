using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TestService.LoginService;

namespace TestService
{
    public partial class Home : System.Web.UI.Page
    {
        IloginRegClient client = new IloginRegClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            dynamic user = client.getAllUsers();
            string display = "";

            foreach (User u in user)
            {
                display += "<div class='col-lg-4 col-sm-6 portfolio-item'>";
                display += "<div class='card h-100'>";
                display += "<p>" + u.FirstName + "</p>";
                display += "</div></div>";
            }

            display += "</div>";
            HomeIcon.InnerHtml = display;
        }
    }
}