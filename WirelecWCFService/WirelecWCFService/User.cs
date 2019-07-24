using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class User
    {
        [DataMember]
        public int UserID { get; set; }
        [DataMember]
        public string Name { get; set; }
        [DataMember]
        public string Username { get; set; }
        [DataMember]
        public string Email { get; set; }
        [DataMember]
        public string Password { get; set; }
        [DataMember]
        public string Tel_Number { get; set; }
        [DataMember]
        public string Address { get; set; }
        [DataMember]
        public string Gender { get; set; }
        [DataMember]
        public string DOB { get; set; }
        [DataMember]
        public string User_Type{ get; set; }
        [DataMember]
        public string pphoto { get; set; }
    }
}