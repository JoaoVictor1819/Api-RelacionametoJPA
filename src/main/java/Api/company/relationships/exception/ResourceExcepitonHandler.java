package Api.company.relationships.exception;

public class ResourceExcepitonHandler extends RuntimeException
{

    public ResourceExcepitonHandler() {
        super("Resource excepiton");
    }

    public ResourceExcepitonHandler(String message)
    {
        super(message);
    }
}
