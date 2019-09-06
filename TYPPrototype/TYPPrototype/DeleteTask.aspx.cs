using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TYPPrototype.UserService;

namespace TYPPrototype
{
    public partial class DeleteTask : System.Web.UI.Page
    {
        UserServiceClient userClient;
        protected void Page_Load(object sender, EventArgs e)
        {
            userClient = new UserServiceClient();
            int id = int.Parse(Request.QueryString["ID"]);
            string x = userClient.DeleteTask(id);
            Response.Write("<script>alert('" + "Task " + id + x + "')</script>");
            Response.Redirect("Tasks.aspx");
        }
    }
}