using System.Runtime.Serialization;

namespace WirelecWCFService
{
    public class Damaged
    {
        [DataMember]
        public int D_ID { get; set; }
        [DataMember]
        public int P_ID { get; set; }
        [DataMember]
        public string DateDamaged { get; set; }
        [DataMember]
        public int Quantity { get; set; }
        [DataMember]
        public string Description { get; set; }
        [DataMember]
        public string P_Photo { get; set; }

    }
}