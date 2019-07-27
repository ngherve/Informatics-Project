using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class DeleteUser : System.Web.UI.Page
    {
        UserServiceClient userClient;
        protected void Page_Load(object sender, EventArgs e)
        {
            string code = Request.QueryString["ID"];
            userClient = new UserServiceClient();
            int id = int.Parse(code);
            string x = userClient.DeleteUser(id);
            Response.Write("<script>alert('" + "User " + id + x + "')</script>");
            Response.Redirect("ManageUsers.aspx");
        }
    }
}