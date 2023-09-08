# Create 3 EC2 instances
# jenkins-master, jenkins-slave, ansible
resource "aws_instance" "tf-ec2" {
  for_each = var.instances_configs
  ami = each.value.amiid
  instance_type = each.value.instance_type
  key_name = each.value.key_name
  subnet_id = aws_subnet.tf_public_subnet_1.id
  vpc_security_group_ids = [aws_security_group.tf_sg_new.id]
  associate_public_ip_address = true
  tags = {
    "Name" = "${each.key}"
  }
  # ansible ====> ansible install should happen
}

# jenkins-master ====> t2.micro

# jenkins-slave ======> t3.medium
# count, for_each 


# ansible ==> ansible install using terraform 

# ansible ==> 1-jenkins-master.yaml ===> Jenkins master setup will be done
# ansible ==> 1-jenkins-slave.yaml ====> installing packages like
    # java
    # maven 

# Jenkins Master setup ==== 
# Can we write a playbook for jenkinsmaser-jenkinsslave setup 
