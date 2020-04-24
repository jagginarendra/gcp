#GCP with rolling restart of pods

gcloud container clusters get-credentials <cluster-name> --zone <zone-info>

git clone <project-url>
build project and generate docker image
docker build -t gcp-app-image .
docker tag gcp-app-image gcr.io/secondproject-275119/gcp-app-image:v1
docker push gcr.io/secondproject-275119/gcp-app-image:v1

to start a pod in cluster 
kubectl run --generator=run-pod/v1 gcp-spring-app --image=gcr.io/secondproject-275119/gcp-app-image:v1 --port=9080

kubectl get pods - to list pods
kubectl get services 
kubectl get deployments

##create a load balancer to access deployments
kubectl expose deployment gcp-spring-app --type=LoadBalancer

using loadbalancer's external IP, we can access the deployed app

##scale the deployment
kubectl scale deployment gcp-spring-app --replicas=4

##To generate the yml in correct format
https://static.brandonpotter.com/kubernetes/DeploymentBuilder.html

##To Deploy latest code 
push the code , build docker image with latest code and apply latest tag 
and update in deployment.yml as below with deployment startegy as given below.
Here we have also configured the health check url.

Use the deployment.yml
kubectl apply - f deployment.yml

apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: gcp-app-image
spec:
  replicas: 3
  strategy:
    type: RollingUpdate
    rollingUpdate:
      maxUnavailable: 0
      maxSurge: 1
  template:
    metadata:
      labels:
        app: gcp-app-image
    spec:
      containers:
        - name: gcp-app-image
          image: gcr.io/secondproject-275119/gcp-app-image:v6
          ports:
            - containerPort: 9080
          readinessProbe:
            httpGet:
              path: /ping
              port: 9080
            initialDelaySeconds: 2
            periodSeconds: 1
            successThreshold: 5
