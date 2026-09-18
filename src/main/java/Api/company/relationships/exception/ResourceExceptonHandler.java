package Api.company.relationships.exception;

public class ResourceExceptonHandler extends RuntimeException
{

    public ResourceExceptonHandler() {
        super("Resource excepiton");
    }

    public ResourceExceptonHandler(String message)
    {
        super(message);
    }
}
