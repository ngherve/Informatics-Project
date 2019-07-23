using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Wirelec_WCF
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "IUserService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select IUserService.svc or IUserService.svc.cs at the Solution Explorer and start debugging.
    public class IUserService : IIUserService
    {
        private static readonly string mycon = "server =localhost; Uid=root; password = ; " +
           "persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True";
        private MySqlConnection connection = new MySqlConnection(mycon);

        public string DeleteUser(int id)
        {
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "DELETE FROM USER WHERE user.UserID = '" + id + "'";
            cmd.ExecuteNonQuery();

            return "User Successfully Deleted";
        }

        public List<User> GetAllUsers()
        {
            List<User> users = new List<User>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM USER";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                User user = null;
                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    users.Add(user);
                }
            }

            return users;
        }

        public User GetUserbyID(int id)
        {
            User user = null;
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM USER WHERE user.UserID = '" + id + "'";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    user.User_Type = dr["User_Type"].ToString();

                }
            }

            return user;
        }

        public bool LoginUser(string username, string password)
        {
            bool SuccessLogin = false;
            try
            {
                connection.Open(); //openning the connection   
                MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
                cmd.CommandType = CommandType.Text; //setting the command type
                cmd.CommandText = "SELECT * FROM USER WHERE Username = '" + username + "' AND Password = '" + password + "'";
                cmd.ExecuteNonQuery();
                DataTable dt = new DataTable();
                MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
                adapter.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    foreach (DataRow dr in dt.Rows)
                    {
                        if (dr["Username"].Equals(username) && dr["Password"].Equals(password))
                        {
                            return true;
                        }
                    }
                }

            }
            catch (Exception ex)
            {
                string response = "<script>alert('" + ex.Message + "')</script>";
                SuccessLogin = false;
            }
            finally
            {
                connection.Close();
            }
            return SuccessLogin;
        }

        public string RegisterUser(User user)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("INSERT INTO USER(Name, Username, Email, Password, Tel_Number, Address, Gender, DOB,User_Type) VALUES(@a1, @a2, @a3, @a4, @a5, @a6, @a7, @a8,@a9)", connection);
                cmd.Parameters.AddWithValue("@a1", user.Name);
                cmd.Parameters.AddWithValue("@a2", user.Username);
                cmd.Parameters.AddWithValue("@a3", user.Email);
                cmd.Parameters.AddWithValue("@a4", user.Password);
                cmd.Parameters.AddWithValue("@a5", user.Tel_Number);
                cmd.Parameters.AddWithValue("@a6", user.Address);
                cmd.Parameters.AddWithValue("@a7", user.Gender);
                cmd.Parameters.AddWithValue("@a8", user.DOB);
                cmd.Parameters.AddWithValue("@a9", user.User_Type);
                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
            finally
            {
                connection.Close();
            }
            return "Data Saved Successfully";
        }

        public User SearchUser(string name)
        {
            User user = null;
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM USER WHERE user.Name LIKE CONCAT( '" + name + "')";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    user.User_Type = dr["User_Type"].ToString();

                }
            }

            return user;
        }

        public string UpdateUser(int id, string name, string username, string email, string pass, string tel, string addr, string gender, string dob, string type)
        {
            User user = new User();
            try
            {
               
                string mycommand = "UPDATE USER SET Name = '"+name+ "',Username= '" + username + "', Email ='" + email + "',Password ='" + pass + "',Tel_Number ='" + tel + "', Address='" + addr + "',Gender ='" + gender + "',DOB = '" + dob + "',User_Type='" + type + "'WHERE user.UserID = '" + id + "'";
                MySqlCommand cmd = new MySqlCommand(mycommand, connection);
                cmd.Parameters.AddWithValue("@a1", user.Name);
                cmd.Parameters.AddWithValue("@a2", user.Username);
                cmd.Parameters.AddWithValue("@a3", user.Email);
                cmd.Parameters.AddWithValue("@a4", user.Password);
                cmd.Parameters.AddWithValue("@a5", user.Tel_Number);
                cmd.Parameters.AddWithValue("@a6", user.Address);
                cmd.Parameters.AddWithValue("@a7", user.Gender);
                cmd.Parameters.AddWithValue("@a8", user.DOB);
                cmd.Parameters.AddWithValue("@a9", user.User_Type);
                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
            finally
            {
                connection.Close();
            }
            return "Data Updated Successfully";
        }
    }
}
