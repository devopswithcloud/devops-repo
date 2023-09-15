# Create a VPC
resource "aws_vpc" "tf_vpc_new" {
  cidr_block = var.vpc_cidr_blocks
  tags = {
    "Name" = "${var.env_prefix}-vpc"
  }
}

# Create a subnet
resource "aws_subnet" "tf_public_subnet_1" {
  cidr_block              = var.subnet_cidr_blocks #"10.1.1.0/24" 
  vpc_id                  = aws_vpc.tf_vpc_new.id
  availability_zone       = var.availability_zone #"us-east-1a"
  map_public_ip_on_launch = true                  #false
  tags = {
    "Name" = "${var.env_prefix}-public-subnet-1"
  }
}

# Create a IGW
resource "aws_internet_gateway" "tf_vpc_igw" {
  vpc_id = aws_vpc.tf_vpc_new.id
  tags = {
    "Name" = "${var.env_prefix}-igw"
  }
}

# Create the route table
resource "aws_route_table" "tf_public_route_table" {
  vpc_id = aws_vpc.tf_vpc_new.id
  tags = {
    "Name" = "${var.env_prefix}-rtb"
  }
}


# Create a route for Internet access 
resource "aws_route" "tf_public_route" {
  route_table_id = aws_route_table.tf_public_route_table.id
  gateway_id = aws_internet_gateway.tf_vpc_igw.id
  destination_cidr_block = "0.0.0.0/0"
}

# Assoiciate a route table with subnet 
resource "aws_route_table_association" "tf_rt_pub_asso" {
  route_table_id = aws_route_table.tf_public_route_table.id
  subnet_id = aws_subnet.tf_public_subnet_1.id
}


# Create a security Group  
resource "aws_security_group" "tf_sg_new" {
  name        = "production-vpc-sg"
  description = "Allow SSH and HTTP from the internet"
  vpc_id = aws_vpc.tf_vpc_new.id
  ingress  {
    description = "Allow ssh"
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = [var.public_ip]
  }
  ingress  {
    description = "Allow http"
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = [var.public_ip]
  }
    ingress  {
    description = "Allow 8080"
    from_port = 8080
    to_port = 8080
    protocol = "tcp"
    cidr_blocks = [var.public_ip]
  }
    ingress  {
    description = "Allow 9000"
    from_port = 9000
    to_port = 9000
    protocol = "tcp"
    cidr_blocks = [var.public_ip]
  }
  # in console, there is no need to create egress/outbound explicitly
  # but in terraform we need to mention the outbound as well
  egress {
    description = "Allow all ports outbound"
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = [var.public_ip]
    ipv6_cidr_blocks = ["::/0"]
  }
  tags = {
    "Name" = "${var.env_prefix}-sg"
  }
}