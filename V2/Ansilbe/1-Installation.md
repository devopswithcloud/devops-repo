```bash
gcloud compute instances create ansible-controller ansible-host  --zone=us-central1-b \
    --machine-type=e2-medium \
    --create-disk=auto-delete=yes,boot=yes,image=projects/ubuntu-os-cloud/global/images/ubuntu-2004-focal-v20241115,mode=rw,size=10,type=pd-balanced
```
