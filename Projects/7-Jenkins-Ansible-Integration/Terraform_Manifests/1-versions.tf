# Settings block
terraform {
  #required_version = "~> 1.0.8" #contstraints 
  # Terraform providers required
  required_providers {
    aws = { # Local name for the manifest
      # version = ">= 5.1.0"
      version = "~> 4.47.0"
      source  = "hashicorp/aws"
      # registry.terraform.io/hashicorp/aws
      # nginx
      # gcr.io/devopswithcloudhub/reponame:tagname
    }
    google = {
      source = "hashicorp/google"
    }

  }
}

# Provider info

provider "aws" {
  region  = "us-east-1"
  profile = "default"
}