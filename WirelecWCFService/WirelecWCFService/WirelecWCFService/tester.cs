using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Windows;
using MySql.Data.MySqlClient;
namespace WirelecWCFService
{
    

    public class tester
    {
        MySqlConnection con = new MySqlConnection("Server=localhost;User Id=root;Password='';Database=Wirelec;");
        MySqlDataAdapter da = new MySqlDataAdapter();
        MySqlCommand cmmd = new MySqlCommand();
        public DataSet ds = new DataSet();

        public void add()
        {
            ds = new DataSet();
            da = new MySqlDataAdapter("Insert into user(UserID,Name,Username,Email,Password,Tel_Numbers,Address,Gender,DOB,User_Type)VALUES(3,Mike,MW,MW@gmail.com,MikeWill,08645464,12 UJAvenue,Male,12/03/1998,Admin)", con);
            da.Fill(ds,"user");
            MessageBox.Show("Added!");
        }
    }
}