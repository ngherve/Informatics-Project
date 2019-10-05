using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WirelecWCFService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Service1.svc or Service1.svc.cs at the Solution Explorer and start debugging.
    public class UserService : IUserService
    {
        private static readonly string mycon = "server =localhost; Uid=root; password = ; " +
           "persistsecurityinfo = True; database =Wirelecdatabase; SslMode = none; Convert Zero Datetime=True; Connect Timeout=3000000; pooling='true'; Max Pool Size=3000000";
        private MySqlConnection connection = new MySqlConnection(mycon);

        public string CreateTask(Task task)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("INSERT INTO Task(Task_ID, UserID, TaskContent, Start_Date, End_Date,Priority, Status, T_Type) VALUES(@a1, @a2, @a3, @a4, @a5, @a6, @a7,@a8)", connection);
                cmd.Parameters.AddWithValue("@a1", task.Task_ID);
                cmd.Parameters.AddWithValue("@a2", task.UserID);
                cmd.Parameters.AddWithValue("@a3", task.TaskContent);
                cmd.Parameters.AddWithValue("@a4", task.Start_Date);
                cmd.Parameters.AddWithValue("@a5", task.End_Date);
                cmd.Parameters.AddWithValue("@a6", task.Priority);
                cmd.Parameters.AddWithValue("@a7", task.Status);
                cmd.Parameters.AddWithValue("@a8", task.T_Type);

                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.CommandTimeout = 1000;
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

        public string DeleteTask(int id)
        {
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "DELETE FROM TASK WHERE Task_ID = '" + id + "'";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();

            return "Task Successfully Deleted";
        }

        public string DeleteUser(int id)
        {
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "DELETE FROM USER WHERE user.UserID = '" + id + "'";
            cmd.CommandTimeout = 1000;
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
            cmd.CommandTimeout = 1000;
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
                    user.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    user.User_Type = dr["User_Type"].ToString();
                    user.pphoto = dr["pphoto"].ToString();
                    users.Add(user);
                }
            }

            return users;
        }

        public List<Notification> GetNotifByUser(int id)
        {
            List<Notification> notifs = new List<Notification>();
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM Notification WHERE UserID = '" + id + "'";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    Notification notif = new Notification();
                    notif.N_ID = Convert.ToInt32(dr["N_ID"].ToString());
                    notif.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    notif.Message = dr["Message"].ToString();
                    notif.N_Datetime = dr["N_Datetime"].ToString();
                    notif.N_Email = dr["N_Email"].ToString();
                    notifs.Add(notif);
                }
            }

            return notifs;
        }

        public List<Notification> GetNotifications()
        {
            List<Notification> notifs = new List<Notification>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM Notification";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                Notification notif = null;
                foreach (DataRow dr in dt.Rows)
                {
                    notif = new Notification();
                    notif.N_ID = Convert.ToInt32(dr["N_ID"].ToString());
                    notif.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    notif.Message = dr["Message"].ToString();
                    notif.N_Datetime = dr["N_Datetime"].ToString();
                    notif.N_Email = dr["N_Email"].ToString();

                    notifs.Add(notif);
                }
            }

            return notifs;
        }

        public List<Task> GetTasks()
        {
            List<Task> tasks = new List<Task>();

            connection.Open(); //openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM Task";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                Task task = null;
                foreach (DataRow dr in dt.Rows)
                {
                    task = new Task();
                    task.Task_ID = Convert.ToInt32(dr["Task_ID"].ToString());
                    task.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    task.TaskContent = dr["TaskContent"].ToString();
                    task.Start_Date = dr["Start_Date"].ToString();
                    task.End_Date = dr["End_Date"].ToString();
                    task.Priority = dr["Priority"].ToString();
                    task.Status = dr["Status"].ToString();
                    task.T_Type = dr["T_Type"].ToString();

                    tasks.Add(task);
                }
            }

            return tasks;
        }

        public User GetUserbyID(int id)
        {
            User user = null;
            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "SELECT * FROM USER WHERE user.UserID = '" + id + "'";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    user.User_Type = dr["User_Type"].ToString();
                    user.pphoto = dr["pphoto"].ToString();
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
                cmd.CommandTimeout = 1000;
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
                MySqlCommand cmd = new MySqlCommand("INSERT INTO USER(Name, Username, Email, Password, Tel_Number, Address, Gender, DOB, User_Type, pphoto) VALUES(@a1, @a2, @a3, @a4, @a5, @a6, @a7, @a8, @a9, @a10)", connection);
                cmd.Parameters.AddWithValue("@a1", user.Name);
                cmd.Parameters.AddWithValue("@a2", user.Username);
                cmd.Parameters.AddWithValue("@a3", user.Email);
                cmd.Parameters.AddWithValue("@a4", user.Password);
                cmd.Parameters.AddWithValue("@a5", user.Tel_Number);
                cmd.Parameters.AddWithValue("@a6", user.Address);
                cmd.Parameters.AddWithValue("@a7", user.Gender);
                cmd.Parameters.AddWithValue("@a8", user.DOB);
                cmd.Parameters.AddWithValue("@a9", user.User_Type);
                cmd.Parameters.AddWithValue("@a10", user.pphoto);
                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.CommandTimeout = 1000;
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

        public string SaveNotif(Notification notif)
        {
            try
            {
                MySqlCommand cmd = new MySqlCommand("INSERT INTO Notification(UserID, Message, N_Datetime, N_Email) VALUES(@a1, @a2, @a3, @a4)", connection);
                cmd.Parameters.AddWithValue("@a1", notif.UserID);
                cmd.Parameters.AddWithValue("@a2", notif.Message);
                cmd.Parameters.AddWithValue("@a3", notif.N_Datetime);
                cmd.Parameters.AddWithValue("@a4", notif.N_Email);

                if (connection.State == ConnectionState.Closed)
                {
                    connection.Open();
                }
                cmd.CommandTimeout = 1000;
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
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter(cmd);
            adapter.Fill(dt);
            if (dt.Rows.Count > 0)
            {

                foreach (DataRow dr in dt.Rows)
                {
                    user = new User();
                    user.UserID = Convert.ToInt32(dr["UserID"].ToString());
                    user.Name = dr["Name"].ToString();
                    user.Username = dr["Username"].ToString();
                    user.Email = dr["Email"].ToString();
                    user.Password = dr["Password"].ToString();
                    user.Tel_Number = dr["Tel_Number"].ToString();
                    user.Address = dr["Address"].ToString();
                    user.Gender = dr["Gender"].ToString();
                    user.DOB = dr["DOB"].ToString();
                    user.User_Type = dr["User_Type"].ToString();
                    user.pphoto = dr["pphoto"].ToString();
                }
            }

            return user;
        }

        public string UpdateUser(User user)
        {

            connection.Open();//openning the connection
            MySqlCommand cmd = connection.CreateCommand(); //creating a cmd
            cmd.CommandType = CommandType.Text; //setting the command type
            cmd.CommandText = "UPDATE USER SET Name = '" + user.Name + "',Username= '" + user.Username +
                "', Email ='" + user.Email + "',Password ='" + user.Password + "',Tel_Number ='" + user.Tel_Number
                + "', Address='" + user.Address + "',Gender ='" + user.Gender + "',DOB = '" + user.DOB
                + "',User_Type='" + user.User_Type + "',pphoto='" + user.pphoto + "'WHERE user.UserID = '" + user.UserID + "'";
            cmd.CommandTimeout = 1000;
            cmd.ExecuteNonQuery();
            return "Data Updated Successfully";
        }
    }
}