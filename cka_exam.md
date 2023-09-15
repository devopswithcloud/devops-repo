

Q1) You have been asked to create a new ClusterRole for a deployment pipeline and bind it to a specific ServiceAccount scoped to a specific namespace. 7%

Task:
	Create a clusterrole named `deployment-clusterrole`, and bind only to create permissions for Deployment, Daemonset, and Statefulset
	Create a serviceaccount named cid-token in the specified named namespace app-team1, and create a last-step clusterrole and the serviceaccount binding


Q5) Create a new NetworkPolicy named allow-port-from-namespace that allows Pods in the existing namespace internal to connect to port 9000 of other Pods in the same namespace.
	Ensure that the new NetworkPolicy:
	- does not allow access to Pods not listening on Port 9000
	- does not allow access from Pods not in namespace internal.



Q6) Reconfigure the existing deployment front-end and add a port specification named http existing port 80/tcp of the existing container nginx.
	- Create a new service named front-end-svc exposing the container port http.
	- Configure the new service to also expose the individual Pods via a NodePort on the nodes on which they are scheduled.

Ans. 




Q8) Scale the deployment loadbalancer to 6 pods.

 


Q9) Schedule a pod as follows:
	- Name: nginx-kusc00401
	- Image: nginx
	- Node selector: disk=spinning


Q10) Check to see how many nodes are ready (not including nodes tainted NoSchedule) and write the number to /opt/KUSC00402/kusc00402.txt

kubectl get nodes | grep -i ready


Q11) Create a pod named kucc1 with a single app container for each of the following images running inside (there may be between 1 and 4 images specified): nginx-redis-memcached-consul



Q12) Create a persistent volume with name app-config, of capacity 2Gi and access mode ReadWriteMany. This type of volume is hostPath and its location is /srv/app-config.



Q13) Create a new PersistentVolumeClaim:
	- Name: pv-volume
	- Class: csi-hostpath-sc
	- Capacity: 10Mi
     Create a new pod which mounts the PersistentVolumeClaim as a volume:
	- Name: web-server
	- image: nginx
	- Mount path: /usr/share/nginx/html

     Configure the new pod to have ReadWriteOnce access on the volume.

     Finally using kubectl edit ot kubectl patch expand the PersistentVolumeClaim to a capacity of 70Mi and record that change.


Ans.


Q14) Monitor the logs of pod foobar and:
	- Extract log lines corresponding to error unable-to-access-website
	- Write them to /opt/KUTR00101/foobar



Q15) 
Context:
	Without changing its existing containers, and existing Pod needs to be integrated into Kubernetes's built-in logging architecture (e.g kubectl logs). Adding a streaming sidecar contaienr is a good and common way to accomplish this requirement.

Task:
	- Add a busybox sidecar container to the exisiting Pod legacy-app. The new app sidecar container has to run the following command:
		/bin/sh -c tail -n+1 -f /var/log/legacy-app.log
	- Use a volume mount named logs to make the file /var/log/legacy-app.log available to the sidecar container.
Note: 
1) Don't modify the existing container
2) Don't modify the path of the log file, both containers must access it at /var/log/legacy-app.log


* esisitng pod convert into yaml 



Ans.
#kubectl get pods legacy=app -o yaml > sidecar.yaml
NOW EDIT THE FILE and add sidecar container



## Pending

Q2) Set the node named ek8s-node-1 to unavailable and reschedule all allowed pods on the node 


Q3) 
Given an existing Kubernetes cluster running version 1.18.8, upgrade all of the Kubernetes control plane and node components on the master node only to version 1.19.0.
You are also expected to upgrade kubelet and kubectl on the master node.


Q4) First create a snapshot of the existing etcd instance running at https://127.0.0.1:2379, saving the snapshot to /srv/data/etcd-snapshot.db
Next, restore an existing, previous snapshot located at /var/lib/backup/etcd-snapshot-previous.db
	The Following TLS certificates/key are supplied for connecting to the server with etcdctl:
	- CA Certificate: /opt/KUIN00601/ca.crt
	- Client Certificate: /opt/KUIN00601/etcd-client.crt
	- Client Key: /opt/KUIN00601/etcd-client.key


Q7) Create a new nginx ingress resource as follows:
	- Name: pong
	- Namespace: ing-internal
	- Exposing service hi on path /hi using service port 5678
The availability of service hi can be checked using the following command, which should return hi:
	#curl -kL <INTERNAL_IP>/hi

Q16) From the pod label name=cpu-user, find pods running high CPU workloads and write the name of the pod consuming most CPU to the file /opt/KUTR00401/KUTR00401.txt (which already exists).





Q17) A kubernetes worker node, named wk8s-node-0 is in state NotReady.
	Investigate why this is the case, and perform any appropriate steps to bring the node to a Ready state, ensuring that any changes are made permanent.




    93% =====> 